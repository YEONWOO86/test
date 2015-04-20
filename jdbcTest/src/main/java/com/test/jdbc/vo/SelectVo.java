package com.test.jdbc.vo;

public class SelectVo {
	private int grno;
    private String grrank;
    
    public SelectVo() {
        // TODO Auto-generated constructor stub
    }
 
    public int getGrno() {
        return grno;
    }
 
    public void setGrno(int grno) {
        this.grno = grno;
    }
 
    public String getGrrank() {
        return grrank;
    }
 
    public void setGrrank(String grrank) {
        this.grrank = grrank;
    }
 
    public SelectVo(int grno, String grrank) {
        super();
        this.grno = grno;
        this.grrank = grrank;
    }
    
}
