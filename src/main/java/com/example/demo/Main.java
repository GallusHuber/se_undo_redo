package com.example.demo;

public class Main {
	public static void main(String[] args) {
		Environment environment = Factory.createEnvironment();
		Factory.createTextEditorUi(environment);
	}
}
