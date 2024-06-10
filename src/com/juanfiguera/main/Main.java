package com.juanfiguera.main;

import com.juanfiguera.view.Window;

public class Main {

	Window window;
	
	public Main() {
		window = new Window(this);
	}
	
	public static void main(String[] args) {
		Main main = new Main();
	}
}
