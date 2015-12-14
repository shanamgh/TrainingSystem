package com.mahan.present;

public enum StudentType {
MS("master"),BS("Bs"),Pdf("pdf");

private String text;
private StudentType (String text){
	this.text = text;
}
@Override
public String toString() {
	return text;
}

}
