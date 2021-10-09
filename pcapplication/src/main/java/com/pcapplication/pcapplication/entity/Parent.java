package com.pcapplication.pcapplication.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="parent1")
public class Parent {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long pid;
	    private String pname;
	    private String pattr;


	    @OneToMany(targetEntity = Child.class, cascade = CascadeType.ALL)
	    @JoinColumn(name = "pid")
	    private List<Child> childs;


		public Long getPid() {
			return pid;
		}


		public void setPid(Long pid) {
			this.pid = pid;
		}


		public String getPname() {
			return pname;
		}


		public void setPname(String pname) {
			this.pname = pname;
		}


		public String getPattr() {
			return pattr;
		}


		public void setPattr(String pattr) {
			this.pattr = pattr;
		}


		public List<Child> getChilds() {
			return childs;
		}


		public void setChilds(List<Child> childs) {
			this.childs = childs;
		}


}
