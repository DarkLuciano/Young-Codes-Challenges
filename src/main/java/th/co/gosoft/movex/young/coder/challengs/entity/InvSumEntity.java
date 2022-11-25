package th.co.gosoft.movex.young.coder.challengs.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "P_INVSUM")
public class InvSumEntity {
	@Id
	@Column(name = "I_INVOICE")	
	private String I_INVOICE;
	@Column(name = "I_ACCOUNT")	
	private String I_ACCOUNT;
	@Column(name = "I_ORDER")	
	private String I_ORDER;
	@Column(name = "I_COMPANY")	
	private String I_COMPANY;
	@Column(name = "C_PAYMODE")	
	private String C_PAYMODE;
	@Column(name = "I_SEASON")	
	private String I_SEASON;
	@Column(name = "I_PARCEL")	
	private String I_PARCEL;
	@Column(name = "F_TURNOVERVAL")	
	private String F_TURNOVERVAL;
	@Column(name = "F_INVOICEVAL")	
	private String F_INVOICEVAL;
	@Column(name = "F_PANDPVAL")	
	private String F_PANDPVAL;
	@Column(name = "D_INVOICE")	
	private String D_INVOICE;
	@Column(name = "F_CASHCREDIT")	
	private String F_CASHCREDIT;
	@Column(name = "F_VOUCHERCREDIT")	
	private String F_VOUCHERCREDIT;
	@Column(name = "F_RETURNVAL")	
	private String F_RETURNVAL;
	@Column(name = "C_PAID")	
	private String C_PAID;
	@Column(name = "F_NONPAIDVAL")	
	private String F_NONPAIDVAL;
	@Column(name = "C_SHIPTO")	
	private String C_SHIPTO;
	@Column(name = "C_REDELIVERY")	
	private String C_REDELIVERY;
	@Column(name = "C_STATUS")	
	private String C_STATUS;
	@Column(name = "F_DISCOUNTVAL")	
	private String F_DISCOUNTVAL;
	@Column(name = "D_DISPATCH")	
	private String D_DISPATCH;
	@Column(name = "C_DISPATCHMODE")	
	private String C_DISPATCHMODE;
	@Column(name = "I_INSTALLMENT")	
	private String I_INSTALLMENT;
	@Column(name = "F_INSTFEERATE")	
	private String F_INSTFEERATE;
	@Column(name = "F_INSTFEEVAL")	
	private String F_INSTFEEVAL;
	@Column(name = "F_1STINSTVAL")	
	private String F_1STINSTVAL;
	@Column(name = "F_ADDTAXVAL")	
	private String F_ADDTAXVAL;
	@Column(name = "C_PANDPTAX")	
	private String C_PANDPTAX;
	@Column(name = "I_PANDP_TAXCODE")	
	private String I_PANDP_TAXCODE;
	@Column(name = "C_INSTFEETAX")	
	private String C_INSTFEETAX;
	@Column(name = "I_INSTFEE_TAXCODE")	
	private String I_INSTFEE_TAXCODE;
	@Column(name = "F_REFUND_INSTFEEVAL")	
	private String F_REFUND_INSTFEEVAL;
	@Column(name = "F_REFUND_PANDPVAL")	
	private String F_REFUND_PANDPVAL;
	@Column(name = "F_EDCMCREDIT")	
	private String F_EDCMCREDIT;
	@Column(name = "D_DELIVERY")	
	private String D_DELIVERY;
	@Column(name = "C_GIFTWRAP")	
	private String C_GIFTWRAP;
	@Column(name = "F_GIFTWRAPFEEVAL")	
	private String F_GIFTWRAPFEEVAL;
	@Column(name = "C_GIFTWRAPFEETAX")	
	private String C_GIFTWRAPFEETAX;
	@Column(name = "I_GIFTWRAPFEE_TAXCODE")	
	private String I_GIFTWRAPFEE_TAXCODE;
	@Column(name = "C_MESSAGE")	
	private String C_MESSAGE;
	@Column(name = "C_POINTS_BURN")	
	private String C_POINTS_BURN;
	@Column(name = "I_POINTS_BURN")	
	private String I_POINTS_BURN;
	@Column(name = "I_POINTS_EARN")	
	private String I_POINTS_EARN;
	@Column(name = "F_POINTS_BURNVAL")	
	private String F_POINTS_BURNVAL;
	@Column(name = "F_REFUND_GIFTWRAPVAL")	
	private String F_REFUND_GIFTWRAPVAL;
	@Column(name = "C_WHOUSE")	
	private String C_WHOUSE;
	@Column(name = "I_ROUTE")	
	private String I_ROUTE;
	@Column(name = "S_TH_INVOICE")	
	private String S_TH_INVOICE;
	@Column(name = "I_SERIES")	
	private String I_SERIES;
	@Column(name = "I_SERIESBIN")	
	private String I_SERIESBIN;
	@Column(name = "S_WHCODE")	
	private String S_WHCODE;
	@Column(name = "I_SHIFT")	
	private String I_SHIFT;
	@Column(name = "D_PICK")	
	private String D_PICK;
	@Column(name = "S_CVS_NO")	
	private String S_CVS_NO;
	@Column(name = "F_INVOICEVAL_CALPOINTS")	
	private String F_INVOICEVAL_CALPOINTS;
	@Column(name = "D_CALPOINTS")	
	private String D_CALPOINTS;
	@Column(name = "I_POINTS_AVAILABLE")	
	private String I_POINTS_AVAILABLE;
	@Column(name = "C_SAMEDAY")	
	private String C_SAMEDAY;
	@Column(name = "C_PREORDER")	
	private String C_PREORDER;
	
	
}
