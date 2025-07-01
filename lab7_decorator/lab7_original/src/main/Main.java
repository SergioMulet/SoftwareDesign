package main;


import fylesystem.FileSystem;
import fylesystem.outputs.Bluetooth;
import fylesystem.outputs.FileOutput;
import fylesystem.outputs.Internet;

public class Main {
	
	public static void main(String[] args) {
		
		FileSystem system = new FileSystem();

		system.copyFile("private.txt", new FileOutput("copy.txt"));
		system.copyFile("private.txt", new Internet("156.35.233.143"));
		system.copyFile("private.txt", new Bluetooth("César's iPhone"));
	}
}
