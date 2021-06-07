package views;

import javax.swing.JFrame;

public abstract class BaseView extends JFrame{
	protected BaseView() {
		initViewComponents();
	}
	protected abstract void initNewJComponents();
	protected void initViewComponents() {
		initNewJComponents();
	};
}
