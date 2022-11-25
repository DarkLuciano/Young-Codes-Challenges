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
@Table(name = "P_BOX_ONBOOK")
public class BoxOnBookEntity {
	@Id
	@Column(name = "I_BOXID")	
	private String I_BOXID;
	@Column(name = "I_SERIAL")	
	private String I_SERIAL;
	@Column(name = "I_INVOICE")	
	private String I_INVOICE;
	@Column(name = "I_ORDER")	
	private String I_ORDER;
	@Column(name = "S_CVS_NO")	
	private String S_CVS_NO;
	@Column(name = "D_CREATE")	
	private String D_CREATE;
	@Column(name = "D_INVOICE")	
	private String D_INVOICE;
	@Column(name = "D_PICKING")	
	private String D_PICKING;
	@Column(name = "D_DELIVERY")	
	private String D_DELIVERY;
	@Column(name = "C_DIRECT")	
	private String C_DIRECT;
	@Column(name = "I_ITEMNO")	
	private String I_ITEMNO;
	@Column(name = "I_SIZE")	
	private String I_SIZE;
	@Column(name = "I_ITEMQTY")	
	private String I_ITEMQTY;
	@Column(name = "I_BOX")	
	private String I_BOX;
	@Column(name = "D_CHANGE")	
	private String D_CHANGE;
	@Column(name = "C_SEPERATEITEM")	
	private String C_SEPERATEITEM;
	@Column(name = "C_EXCEED")	
	private String C_EXCEED;
	@Column(name = "C_SOURCE")	
	private String C_SOURCE;
	@Column(name = "I_TYPE")	
	private String I_TYPE;
	@Column(name = "C_TYPE")	
	private String C_TYPE;
	@Column(name = "C_WHOUSE")	
	private String C_WHOUSE;
	@Column(name = "I_ZIPCODE")	
	private String I_ZIPCODE;
	@Column(name = "I_BOX_RUNNING")	
	private String I_BOX_RUNNING;
	@Column(name = "I_BOX_TOTAL")	
	private String I_BOX_TOTAL;
	
}
