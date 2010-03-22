/**
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2010 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 */
package ti.modules.titanium.ui;

import java.util.ArrayList;
import java.util.Arrays;

import org.appcelerator.titanium.TiContext;
import org.appcelerator.titanium.TiDict;
import org.appcelerator.titanium.proxy.TiViewProxy;
import org.appcelerator.titanium.util.AsyncResult;
import org.appcelerator.titanium.util.TiConfig;
import org.appcelerator.titanium.util.TiConvert;
import org.appcelerator.titanium.view.TiUIView;

import ti.modules.titanium.ui.widget.TiUITableView;
import android.app.Activity;
import android.os.Message;

public class TableViewProxy extends TiViewProxy
{
    private static final String LCAT = "TableViewProxyl";
    private static final boolean DBG = TiConfig.LOGD;

    private static final int MSG_UPDATE_VIEW = TiViewProxy.MSG_LAST_ID + 5001;
    private static final int MSG_SCROLL_TO_INDEX = TiViewProxy.MSG_LAST_ID + 5002;
    
    public static final String CLASSNAME_DEFAULT = "__default__";
    public static final String CLASSNAME_HEADER = "__header__";
    public static final String CLASSNAME_NORMAL = "__normal__";

    class RowResult {
    	int sectionIndex;
    	TableViewSectionProxy section;
    	TableViewRowProxy row;
    	int rowIndexInSection;
    }

    private ArrayList<TableViewSectionProxy> localSections;

	public TableViewProxy(TiContext tiContext, Object[] args) {
		super(tiContext, args);
		
		Object o = getDynamicValue("data");
		if (o != null) {
			processData((Object[]) o);
		}
	}

	@Override
	public TiUIView createView(Activity activity) {
		return new TiUITableView(this);
	}

	public TiUITableView getTableView() {
		return (TiUITableView) getView(getTiContext().getActivity());
	}
	
	public void updateRow(Object row, TiDict data, TiDict options) {
		TableViewRowProxy rowProxy = null;
		TableViewSectionProxy sectionProxy = null;
		int rowIndex = -1;
		
		if (row instanceof Number) {
			RowResult rr = new RowResult();

			rowIndex = ((Number)row).intValue();
			locateIndex(rowIndex, rr);
			rowProxy = rr.row;
			sectionProxy = rr.section;
		} else if (row instanceof TableViewRowProxy) {
			ArrayList<TableViewSectionProxy> sections = getSections();
			sectionLoop: for (int i = 0; i < sections.size(); i++) {
				ArrayList<TableViewRowProxy> rows = sections.get(i).rows;
				for (int j = 0; j < rows.size(); j++) {
					if (rows.get(j) == row) {
						rowProxy = (TableViewRowProxy)row;
						sectionProxy = sections.get(i);
						rowIndex = j;
						break sectionLoop;
					}
				}
			}
		}
		
		if (sectionProxy != null) {
			sectionProxy.updateRowAt(rowIndex, rowProxyFor(data));
			getTableView().setModelDirty();
			updateView();
		}
	}

	public void appendRow(Object row, TiDict options)
	{
		TableViewRowProxy rowProxy = rowProxyFor(row);
		ArrayList<TableViewSectionProxy> sections = getSections();
		if (sections.size() == 0) {
			Object[] data = { rowProxy };
			processData(data);
		} else {
			TableViewSectionProxy lastSection = sections.get(sections.size() - 1);
			rowProxy.setDynamicValue("section", lastSection);
			rowProxy.setDynamicValue("parent", lastSection);

			lastSection.insertRowAt((int) lastSection.getRowCount(), rowProxy);
			getTableView().setModelDirty();
		}
		
		updateView();
	}

	public void deleteRow(int index, TiDict options)
	{
		RowResult rr = new RowResult();
		if (locateIndex(index, rr)) {
			rr.section.removeRowAt(rr.rowIndexInSection);
			getTableView().setModelDirty();
			updateView();
		} else {
        	throw new IllegalStateException("Index out of range. Non-existant row at " + index);
		}
	}

	public int getIndexByName(String name) {
        int index = -1;
        int idx = 0;
        if (name != null) {
        	for(TableViewSectionProxy section : getSections()) {
        		for (TableViewRowProxy row : section.getRows()) {
        			String rname = TiConvert.toString(row.getDynamicValue("name"));
    				if(rname != null && name.equals(rname)) {
    					index = idx;
    					break;
    				}
    				idx++;
        		}
        		if (index > -1) {
        			break;
        		}
        	}
        }
        return index;
	}

	public void insertRowBefore(int index, Object data, TiDict options)
	{
        if (getSections().size() > 0) {
            if (index < 0) {
                index = 0;
            }

            RowResult rr = new RowResult();
            if (locateIndex(index, rr)) {
            	TableViewRowProxy rowProxy = rowProxyFor(data);
             	rr.section.insertRowAt(rr.rowIndexInSection, rowProxy);
            } else {
            	throw new IllegalStateException("Index out of range. Non-existant row at " + index);
            }
        } else {
        	// Add first row.
            Object[] args = { rowProxyFor(data) };
            processData(args);
        }
        getTableView().setModelDirty();
		updateView();
	}

	public void insertRowAfter(int index, Object data, TiDict options)
	{
        RowResult rr = new RowResult();
        if (locateIndex(index, rr)) {
        	// TODO check for section
        	TableViewRowProxy rowProxy = rowProxyFor(data);
        	rr.section.insertRowAt(rr.rowIndexInSection + 1, rowProxy);
        	getTableView().setModelDirty();
			updateView();
        } else {
        	throw new IllegalStateException("Index out of range. Non-existant row at " + index);
        }
	}

	public void scrollToIndex(int index, TiDict options) {
		getTableView().scrollToIndex(index);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<TableViewSectionProxy> getSections()
	{
		ArrayList<TableViewSectionProxy> sections = localSections;
		if (sections == null) {
			sections = new ArrayList<TableViewSectionProxy>();
			localSections = sections;
		}
		return sections;
	}
	
	public void processData(Object[] data)
	{
		ArrayList<TableViewSectionProxy> sections = getSections();
		sections.clear();

        TableViewSectionProxy currentSection = null;

		for(int i = 0; i < data.length; i++) {
			Object o = data[i];

			if (o instanceof TiDict) {
				TiDict d = (TiDict) o;
	            Object[] args = { d };
	            TableViewRowProxy rowProxy = new TableViewRowProxy(getTiContext(), args);
	            rowProxy.setDynamicValue("className", CLASSNAME_NORMAL);
	            rowProxy.setDynamicValue("rowData", data);

	            if (currentSection == null || d.containsKey("header")) {
	            	currentSection = new TableViewSectionProxy(getTiContext(), new Object[0]);
	            	sections.add(currentSection);
	            }
	            if (d.containsKey("header")) {
	            	currentSection.setDynamicValue("headerTitle", d.get("header"));
	            }
	            if (d.containsKey("footer")) {
	            	currentSection.setDynamicValue("footerTitle", d.get("footer"));
	            }
	            currentSection.add(rowProxy);
			} else if (o instanceof TableViewRowProxy) {
				TableViewRowProxy rowProxy = (TableViewRowProxy) o;
				TiDict d = rowProxy.getDynamicProperties();

	            if (currentSection == null || d.containsKey("header")) {
	            	currentSection = new TableViewSectionProxy(getTiContext(), new Object[0]);
	            	sections.add(currentSection);
	            }
	            if (d.containsKey("header")) {
	            	currentSection.setDynamicValue("headerTitle", d.get("header"));
	            }
	            if (d.containsKey("footer")) {
	            	currentSection.setDynamicValue("footerTitle", d.get("footer"));
	            }

				currentSection.add((TableViewRowProxy) o);
			} else if (o instanceof TableViewSectionProxy) {
				currentSection = (TableViewSectionProxy) o;
				sections.add(currentSection);
			}
		}
	}

	public void setData(Object[] data, TiDict options) {
		processData(data);
		getTableView().setModelDirty();
		updateView();
	}
	
	public Object[] getData() {
		ArrayList<TableViewRowProxy> rows = new ArrayList<TableViewRowProxy>();
		ArrayList<TableViewSectionProxy> sections = getSections();
		for (int i = 0; i < sections.size(); i++) {
			rows.addAll(Arrays.asList(sections.get(i).getRows()));
		}
		return rows.toArray();
	}

	private TableViewRowProxy rowProxyFor(Object row) {
		if (row instanceof TiDict) {
			TiDict d = (TiDict) row;
            Object[] args = { d };
            TableViewRowProxy rowProxy = new TableViewRowProxy(getTiContext(), args);
            rowProxy.setDynamicValue("className", CLASSNAME_NORMAL);
            rowProxy.setDynamicValue("rowData", row);
            return rowProxy;
		}
		return (TableViewRowProxy) row;
	}

    private boolean locateIndex(int index, RowResult rowResult)
    {
    	boolean found = false;
    	int rowCount = 0;
    	int sectionIndex = 0;

    	for(TableViewSectionProxy section : getSections()) {
    		int sectionRowCount = (int) section.getRowCount();
    		if (sectionRowCount + rowCount > index) {
				rowResult.section = section;
				rowResult.sectionIndex = sectionIndex;
				rowResult.row = section.getRows()[index - rowCount];
				rowResult.rowIndexInSection = index - rowCount;
				found = true;
				break;
    		} else {
    			rowCount += sectionRowCount;
    		}

    		sectionIndex += 1;
    	}

    	return found;
    }
    
    public void updateView() {
		AsyncResult result = new AsyncResult();
		Message msg = getUIHandler().obtainMessage(MSG_UPDATE_VIEW);
		msg.obj = result;
		msg.sendToTarget();
		result.getResult();
    }
    
    public void scrollToIndex(int index) {
    	Message msg = getUIHandler().obtainMessage(MSG_SCROLL_TO_INDEX);
		msg.arg1 = index;
		msg.sendToTarget();
    }
    
    @Override
    public boolean handleMessage(Message msg) {
    	if (msg.what == MSG_UPDATE_VIEW) {
    		getTableView().updateView();
    		((AsyncResult)msg.obj).setResult(0);
    		return true;
    	} else if (msg.what == MSG_SCROLL_TO_INDEX) {
    		getTableView().scrollToIndex(msg.arg1);
    		return true;
    	}
    	
    	return super.handleMessage(msg);
    }
}
