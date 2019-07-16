package com.cg.pos.utility;

/**
 * database queries
 * 
 * @author prakhar
 *
 */
public final class DBQueries {

	public static String ViewCustomer = "select cname from customer where cid = ?";
	public static String SEARCH_STORE = "select storeid,storename,storeaddress,storecontact,ownername from store where storename=?";
	public static String VIEW_PIZZA = "select storeid,itemid,quantity,price,pizzaname from pizza where storeid=?";
	public static String DBCHECK = "select pizza.itemid from pizza inner join store on pizza.storeid=store.storeid where store.storename=? and pizza.itemid=?";
	public static String ADDTOCART = "insert into cart (cartid,quantity,restcharge,delvcharge,total) values(NEXTVAL.NEXTVAL,?,?,?,?)";
	public static String GETPRICE = "select price from pizza where itemid=? ";
	public static String VIEW_CART_BY_ID = "select * from cart where cartid =?";
	public static String DELFROMCART = "delete from cart where cartid=?";
	public static String UPDATECART = "update cart set quantity=? where cartid=?";
	public static String ADDORDER = "insert into ordertable (orderid,cartid) values (NEXTVAL.NEXTVAL,?)";
	public static String GETID = "select cartid from cart where cartid=?";
}
