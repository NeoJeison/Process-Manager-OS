package com.operational.processManager.model;

public class ActualProcess {
	
	private String user;
	private String pid;
	private String cpu;
	private String mem;
	private String vsz;
	private String rss;
	private String tty;
	private String stat;
	private String start;
	private String time;
	private String command;
	
	public ActualProcess() {}
	
	public ActualProcess(String user, String pid, String cpu, String mem, String vsz, String rss, String tty,
			String stat, String start, String time, String command) {
		super();
		this.user = user;
		this.pid = pid;
		this.cpu = cpu;
		this.mem = mem;
		this.vsz = vsz;
		this.rss = rss;
		this.tty = tty;
		this.stat = stat;
		this.start = start;
		this.time = time;
		this.command = command;
	}

	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public String getMem() {
		return mem;
	}
	public void setMem(String mem) {
		this.mem = mem;
	}
	public String getVsz() {
		return vsz;
	}
	public void setVsz(String vsz) {
		this.vsz = vsz;
	}
	public String getRss() {
		return rss;
	}
	public void setRss(String rss) {
		this.rss = rss;
	}
	public String getTty() {
		return tty;
	}
	public void setTty(String tty) {
		this.tty = tty;
	}
	public String getStat() {
		return stat;
	}
	public void setStat(String stat) {
		this.stat = stat;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	

}
