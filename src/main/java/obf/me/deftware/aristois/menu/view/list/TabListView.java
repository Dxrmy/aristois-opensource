/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  me.deftware.client.framework.message.Message
 */
package me.deftware.aristois.menu.view.list;

import \u0000nunyaboolean.catch.for.if.break.synchronized;
import \u0000nunyaboolean.catch.for.super.break.default;
import \u0000nunyaboolean.catch.for.super.enum.interface;
import java.util.ArrayList;
import java.util.List;
import me.deftware.aristois.menu.view.container.ContainerWidget;
import me.deftware.aristois.menu.view.list.ListWidget;
import me.deftware.aristois.menu.widgets.ButtonWidget;
import me.deftware.client.framework.message.Message;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class TabListView
extends ContainerWidget {
    protected int selectedIndex = 0;
    protected List<ContainerWidget> tabs = new ArrayList<ContainerWidget>();
    protected ListWidget list;

    public TabListView(double d, double d2, double d3, double d4, interface interface_) {
        super(d, d2, d3, d4, interface_);
        this.list = new ListWidget(interface_);
        this.list.implements(default.goto\u00a0null);
        this.list.static().if(80.0);
        this.implements(new synchronized[]{this.list});
    }

    public ContainerWidget addTab(Message message) {
        ContainerWidget containerWidget = new ContainerWidget(this.list.static().switch(), 0.0, 0.0, 0.0, this.volatile\u00a0do);
        containerWidget.implements(default.goto\u00a0transient, default.goto\u00a0null);
        containerWidget.implements((synchronized)this);
        this.tabs.add(containerWidget);
        final int n = this.tabs.size() - 1;
        ButtonWidget buttonWidget = new ButtonWidget(message, this.volatile\u00a0do){

            @Override
            protected void onClick(int n2) {
                TabListView.this.selectedIndex = n;
            }
        };
        buttonWidget.implements(default.goto\u00a0transient);
        this.list.implements(new synchronized[]{buttonWidget});
        return containerWidget;
    }

    @Override
    public void implements() {
        super.implements();
        this.tabs.forEach(synchronized::implements);
    }

    @Override
    protected boolean drawChildren(double d, double d2, float f, boolean bl) {
        bl = super.drawChildren(d, d2, f, bl);
        bl = this.tabs.get(this.selectedIndex).implements(d, d2, f, false);
        return bl;
    }

    @Override
    public boolean implements(double d, double d2, int n) {
        if (this.tabs.get(this.selectedIndex).implements(d, d2, n)) {
            return true;
        }
        return super.implements(d, d2, n);
    }

    @Override
    public boolean long(double d, double d2, int n) {
        boolean bl = super.long(d, d2, n);
        bl = this.tabs.get(this.selectedIndex).long(d, d2, n);
        return bl;
    }

    @Override
    public void switch() {
        super.switch();
        this.tabs.get(this.selectedIndex).switch();
    }

    public int getSelectedIndex() {
        return this.selectedIndex;
    }

    public void setSelectedIndex(int n) {
        this.selectedIndex = n;
    }

    public List<ContainerWidget> getTabs() {
        return this.tabs;
    }

    public ListWidget getList() {
        return this.list;
    }
}

