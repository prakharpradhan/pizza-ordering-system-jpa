package com.cg.pos.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * bean class for store details
 * 
 * @author Prakhar
 *
 */
@NamedQueries(@NamedQuery(name = "findStoreName", query = "select  d from StoreDetails d where d.storeName=?"))
@Entity
@Table(name = "store")
public class StoreDetails {
	@Id

	private int storeId;
	private String storeName;
	private String storeAddress;
	private String storeContact;
	private String ownerName;
	@OneToMany(mappedBy = "store", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<PizzaDetails> list = new ArrayList<PizzaDetails>();

	public List<PizzaDetails> getList() {
		return list;
	}

	public void setList(List<PizzaDetails> list) {
		this.list = list;
	}

	public StoreDetails(int storeId, String storeName, String storeAddress, String storeContact, String ownerName) {

		this.storeId = storeId;
		this.storeName = storeName;
		this.storeAddress = storeAddress;
		this.storeContact = storeContact;
		this.ownerName = ownerName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public StoreDetails() {
		// TODO Auto-generated constructor stub
	}

	// Getter and Setter to Access private Member
	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public String getStoreContact() {
		return storeContact;
	}

	public void setStoreContact(String storeContact) {
		this.storeContact = storeContact;
	}

	@Override
	public String toString() {
		return "StoreDetails: \n StoreId=" + storeId + "\n" + "StoreName=" + storeName + "\n" + "StoreAddress="
				+ storeAddress + "\n" + "StoreContact=" + storeContact + "\n" + "OwnerName=" + ownerName + "\n";
	}

}
