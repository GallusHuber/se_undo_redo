package com.example.demo;

import com.example.demo.ui.ITextEditorUi;

public class DemoApplication {

	public static void main(String[] args) {
		ITextEditorUi textEditorUi = Factory.getTextEditorUi();
	}

}
