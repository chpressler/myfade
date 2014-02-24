package biz.pressler.myfade.components;

import biz.pressler.myfade.actions.FTPAction;
import biz.pressler.myfade.actions.MoveBackAction;
import biz.pressler.myfade.actions.MoveForwardAction;
import biz.pressler.myfade.actions.RefreshAction;
import biz.pressler.myfade.actions.SearchAction;
import javax.swing.JToolBar;

public class FaDEToolBar extends JToolBar {
	
	private static final long serialVersionUID = 1L;

	public FaDEToolBar() {
//		setBackground(new Color(80, 30, 30));
//		putClientProperty(Options.HEADER_STYLE_KEY, HeaderStyle.BOTH);
		setFloatable(false);
//        putClientProperty("JToolBar.isRollover", Boolean.TRUE);
        
		this.add(new MoveBackAction());
		this.add(new MoveForwardAction());
		this.addSeparator();
		this.add(new RefreshAction());
		this.add(new SearchAction());
		this.add(new FTPAction());
	}

}
