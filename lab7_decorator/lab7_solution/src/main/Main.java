package main;


import fylesystem.FileSystem;
import fylesystem.outputs.Bluetooth;
import fylesystem.outputs.FileOutput;
import fylesystem.outputs.Internet;
import modifications.Encrypt;
import modifications.Normalize;

public class Main {
	
	public static void main(String[] args) {
		
		FileSystem system = new FileSystem();

		// More modifications to add, but same thing, note that apart from decorator we are using composite also
		system.copyFile("private.txt", new Encrypt(new Normalize(new FileOutput("copy.txt"))));
		system.copyFile("private.txt", new Internet("156.35.233.143"));
		system.copyFile("private.txt", new Bluetooth("César's iPhone"));
	}
}
