package th.co.gosoft.movex.young.coder.challengs.entity;

import java.sql.Date;

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
@Table(name = "P_ORDSUM")
public class OrderSumEntity {
	@Id
	@Column(name = "I_ORDER")	
	private String order;
	@Column(name = "I_ACCOUNT")	
	private String account;
	@Column(name = "I_COMPANY")	
	private String company;
	@Column(name = "I_ORDERQTY")	
	private String orderQty;
	@Column(name = "F_ORDERVAL")	
	private String orderVal;
	@Column(name = "I_OPENDET")	
	private String openDet;
	@Column(name = "F_OPENVAL")	
	private String openVal;
	@Column(name = "F_PANDPVAL")	
	private String pandpVal;
	@Column(name = "I_ORDERFILE")	
	private String oederFile;
	@Column(name = "C_PANDP")	
	private String pandp;
	@Column(name = "C_INSTFEE")	
	private String instFee;
	@Column(name = "C_PAYMODE")	
	private String paymode;
	@Column(name = "C_ORDERTYPE")	
	private String orderType;
	@Column(name = "C_STATUS")	
	private String status;
	@Column(name = "C_SHIPTO")	
	private String shipTo;
	@Column(name = "C_NEWCUST")	
	private String newCust;
	@Column(name = "I_INSTALLMENT")	
	private String installment;
	@Column(name = "F_INSTFEEVAL")	
	private String instFeeVal;
	@Column(name = "F_INSTFEERATE")	
	private String instFeeRate;
	@Column(name = "F_ADDTAXVAL")	
	private String addTaxVal;
	@Column(name = "C_PANDPTAX")	
	private String pandpTax;
	@Column(name = "I_PANDP_TAXCODE")	
	private String pandpTaxCode;
	@Column(name = "C_INSTFEETAX")	
	private String instFeeTax;
	@Column(name = "I_INSTFEE_TAXCODE")	
	private String instFeeTaxCode;
	@Column(name = "I_ACTION")	
	private String action;
	@Column(name = "I_PRIORITY")	
	private String priority;
	@Column(name = "C_DELIVERY")	
	private String delivery;
	@Column(name = "I_DUE_PERIOD")	
	private String duePeriod;
	@Column(name = "D_DUE")	
	private String due;
	@Column(name = "C_CASHCREDIT")	
	private String cashCredit;
	@Column(name = "F_EDCMCREDIT")	
	private String edcmCredit;
	@Column(name = "F_EDCMCREDIT_USED")	
	private String edcmCreditUsed;
	@Column(name = "D_CREATE")	
	private Date create;
	@Column(name = "D_BALINVALID")	
	private String balinvalId;
	@Column(name = "S_OPCODE")	
	private String opcode;
	@Column(name = "S_EXTERN_ORDERNO")	
	private String externOrderNo;
	@Column(name = "C_MESSAGE")	
	private String message;
	@Column(name = "D_DELIVERY")	
	private String delevery;
	@Column(name = "C_GIFTWRAP")	
	private String giftwrap;
	@Column(name = "F_GIFTWRAPFEEVAL")	
	private String giftwrapFeeVal;
	@Column(name = "C_GIFTWRAPFEETAX")	
	private String giftwrapFeeTax;
	@Column(name = "I_GIFTWRAPFEE_TAXCODE")	
	private String giftwrapFeeTaxCode;
	@Column(name = "C_POINTS_BURN")	
	private String cPointBern;
	@Column(name = "I_POINTS_BURN")	
	private String iPointBren;
	@Column(name = "I_POINTS_BURN_USED")	
	private String iPointBrenUsed;
	@Column(name = "I_CLUB")	
	private String club;
	@Column(name = "C_WHOUSE")	
	private String whouse;
	@Column(name = "I_ORDERSOURCE")	
	private String ordersource;
	@Column(name = "D_DISPOS")	
	private String dispos;
	@Column(name = "I_COMPL_SHIP_PERIOD")	
	private String complShipPeriod;
	@Column(name = "S_CVS_NO")	
	private String cvsNo;
	@Column(name = "C_COMPLETE_ADDRESS")	
	private String completeAddress;
	@Column(name = "C_POINTS_PASS")	
	private String pointsPass;
	@Column(name = "S_BANKHIREPUR")	
	private String S_BANKHIREPUR;
	@Column(name = "I_SUBPAYMODE")	
	private String I_SUBPAYMODE;
	@Column(name = "F_SMARTPURSE_VALUE")	
	private String F_SMARTPURSE_VALUE;
	@Column(name = "I_SMARTPURSE_POINTS")	
	private String I_SMARTPURSE_POINTS;
	@Column(name = "S_CVS_NO_STORE_CALL_ORDERS")	
	private String S_CVS_NO_STORE_CALL_ORDERS;
	@Column(name = "S_CVS_NO_STORE_PAID")	
	private String S_CVS_NO_STORE_PAID;
	@Column(name = "S_OPCODE_AGENT")	
	private String S_OPCODE_AGENT;
	@Column(name = "D_CREATETIME")	
	private String D_CREATETIME;
	@Column(name = "C_STORE_ONL")	
	private String C_STORE_ONL;
	@Column(name = "D_TAKEOVER")	
	private String D_TAKEOVER;
	@Column(name = "I_CCARD_POINTS")	
	private String I_CCARD_POINTS;
	@Column(name = "F_CCARD_POINTS_AMOUNT")	
	private String F_CCARD_POINTS_AMOUNT;
	@Column(name = "I_PAYMENT_TYPE")	
	private String I_PAYMENT_TYPE;
	@Column(name = "S_PAYM_ATTRIB1")	
	private String S_PAYM_ATTRIB1;
	@Column(name = "S_PAYM_ATTRIB2")	
	private String S_PAYM_ATTRIB2;
	@Column(name = "S_PAYM_ATTRIB3")	
	private String S_PAYM_ATTRIB3;
	@Column(name = "S_PAYM_ATTRIB4")	
	private String S_PAYM_ATTRIB4;
	@Column(name = "S_PAYM_ATTRIB5")	
	private String S_PAYM_ATTRIB5;
	@Column(name = "S_PAYM_ATTRIB6")	
	private String S_PAYM_ATTRIB6;
	@Column(name = "C_CVP")	
	private String C_CVP;
	@Column(name = "S_EXTERN_PARENTNO")	
	private String S_EXTERN_PARENTNO;
	@Column(name = "C_AUTOCAL_DELIVERY")	
	private String C_AUTOCAL_DELIVERY;
	@Column(name = "C_FLAG")	
	private String C_FLAG;
	@Column(name = "D_UPDATE_FLAG")	
	private String D_UPDATE_FLAG;
	@Column(name = "S_REF_ORDERNO")	
	private String S_REF_ORDERNO;
	@Column(name = "C_ALL_NETWORK_TYPE")	
	private String C_ALL_NETWORK_TYPE;
	@Column(name = "S_ALL_NETWORK_CODE")	
	private String S_ALL_NETWORK_CODE;
	@Column(name = "D_PAYMENT")	
	private String D_PAYMENT;
	@Column(name = "C_SKIP_AUTO_SMS")	
	private String C_SKIP_AUTO_SMS;
	@Column(name = "S_ALLMEMBER_ID")	
	private String S_ALLMEMBER_ID;
	@Column(name = "S_ALLMEMBER_TYPE")	
	private String S_ALLMEMBER_TYPE;
	@Column(name = "D_UPDATE")	
	private String D_UPDATE;
}


