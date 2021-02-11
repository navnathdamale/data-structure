package com.java.practice.design.behaviour.momento;

public class MomentoOriginator {

	private String fileName;
	private StringBuilder content;

	public MomentoOriginator(String fileName) {
		this.fileName = fileName;
		this.content = new StringBuilder();
	}

	public void write(String content) {
		this.content.append(content);
	}

	public void undoToLastSaved(Object object) {
		Momento momento = (Momento) object;
		this.fileName = momento.fileName;
		this.content = momento.content;
	}

	@Override
	public String toString() {
		return "MomentoOriginator [fileName=" + fileName + ", content=" + content + "]";
	}

	public Momento save() {
		return new Momento(this.fileName, this.content);
	}

	private class Momento {
		private String fileName;
		private StringBuilder content;

		public Momento(String fileName, StringBuilder content) {
			this.fileName = fileName;
			this.content = new StringBuilder(content);
		}
	}
}
