package controllers;

import views.BaseView;

public abstract class BaseController {
	private BaseView view;
	
	abstract void initView();
	abstract void initController();
	abstract BaseView getView();
}
