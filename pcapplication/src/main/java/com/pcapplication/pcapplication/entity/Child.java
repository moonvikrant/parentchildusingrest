package com.pcapplication.pcapplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="child1")
public class Child {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long cid;
	    private String cname;
	    @Column(unique = true)
	    private String cattr;
	    
	    public Long getCid() {
			return cid;
		}

		public void setCid(Long cid) {
			this.cid = cid;
		}

		public String getCname() {
			return cname;
		}

		public void setCname(String cname) {
			this.cname = cname;
		}

		public String getCattr() {
			return cattr;
		}

		public void setCattr(String cattr) {
			this.cattr = cattr;
		}

		public Parent getParent() {
			return parent;
		}

		public void setParent(Parent parent) {
			this.parent = parent;
		}

		/*
		 * public String getPname() { return pname; }
		 * 
		 * public void setPname(String pname) { this.pname = pname; }
		 */
		@ManyToOne
	    @JsonIgnore
	    private Parent parent;
	    
		/*
		 * @Transient private String pname;
		 */
	    
	
	}

