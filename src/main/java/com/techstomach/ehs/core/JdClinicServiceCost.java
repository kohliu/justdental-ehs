//package com.techstomach.ehs.core;
//
//import java.io.Serializable;
//import java.util.Collections;
//import java.util.Date;
//import java.util.Map;
//import java.util.WeakHashMap;
//import javax.persistence.Basic;
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//import javax.persistence.Transient;
//import org.hibernate.proxy.HibernateProxy;
//
//
///**
// * Object mapping for hibernate-handled table: jd_clinic_service_cost.
// * @author autogenerated
// */
//
//@Entity
//@Table(name = "jd_clinic_service_cost", catalog = "jdehs_dev")
//public class JdClinicServiceCost implements Cloneable, Serializable{
//
//	/** Serial Version UID. */
//	private static final long serialVersionUID = -559033264L;
//
//	/** Use a WeakHashMap so entries will be garbage collected once all entities
//		referring to a saved hash are garbage collected themselves. */
//	private static final Map<Serializable, Serializable> SAVED_HASHES =
//		Collections.synchronizedMap(new WeakHashMap<Serializable, Serializable>());
//
//	/** hashCode temporary storage. */
//	private volatile Serializable hashCode;
//
//
//	/** Field mapping. */
//	private JdClinic clinicidFk;
//	/** Field mapping. */
//	private Double cost;
//	/** Field mapping. */
//	private Date creationdate;
//	/** Field mapping. */
//	private String modifiedby;
//	/** Field mapping. */
//	private Date modifieddate;
//	/** Field mapping. */
//	private JdServices serviceidFk;
//
//
//
//
//	/** Return the type of this class. Useful for when dealing with proxies.
//	* @return Defining class.
//	*/
//	@Transient
//	public Class<?> getClassType() {
//		return JdClinicServiceCost.class;
//	}
//
//
//    /**
//     * Return the value associated with the column: clinicidFk.
//	 * @return A JdClinic object (this.clinicidFk)
//	 */
//	@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
//	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
//	@Basic( optional = false )
//	@JoinColumn(name = "clinicId_fk", nullable = false )
//	public JdClinic getClinicidFk() {
//		return this.clinicidFk;
//
//	}
//
//
//
//    /**
//     * Set the value related to the column: clinicidFk.
//	 * @param clinicidFk the clinicidFk value you wish to set
//	 */
//	public void setClinicidFk(final JdClinic clinicidFk) {
//		this.clinicidFk = clinicidFk;
//	}
//
//    /**
//     * Return the value associated with the column: cost.
//	 * @return A Double object (this.cost)
//	 */
//	public Double getCost() {
//		return this.cost;
//
//	}
//
//
//
//    /**
//     * Set the value related to the column: cost.
//	 * @param cost the cost value you wish to set
//	 */
//	public void setCost(final Double cost) {
//		this.cost = cost;
//	}
//
//    /**
//     * Return the value associated with the column: creationdate.
//	 * @return A Date object (this.creationdate)
//	 */
//	public Date getCreationdate() {
//		return this.creationdate;
//
//	}
//
//
//
//    /**
//     * Set the value related to the column: creationdate.
//	 * @param creationdate the creationdate value you wish to set
//	 */
//	public void setCreationdate(final Date creationdate) {
//		this.creationdate = creationdate;
//	}
//
//    /**
//     * Return the value associated with the column: modifiedby.
//	 * @return A String object (this.modifiedby)
//	 */
//	@Basic( optional = false )
//	@Column( nullable = false, length = 255  )
//	public String getModifiedby() {
//		return this.modifiedby;
//
//	}
//
//
//
//    /**
//     * Set the value related to the column: modifiedby.
//	 * @param modifiedby the modifiedby value you wish to set
//	 */
//	public void setModifiedby(final String modifiedby) {
//		this.modifiedby = modifiedby;
//	}
//
//    /**
//     * Return the value associated with the column: modifieddate.
//	 * @return A Date object (this.modifieddate)
//	 */
//	public Date getModifieddate() {
//		return this.modifieddate;
//
//	}
//
//
//
//    /**
//     * Set the value related to the column: modifieddate.
//	 * @param modifieddate the modifieddate value you wish to set
//	 */
//	public void setModifieddate(final Date modifieddate) {
//		this.modifieddate = modifieddate;
//	}
//
//    /**
//     * Return the value associated with the column: serviceidFk.
//	 * @return A JdServices object (this.serviceidFk)
//	 */
//	@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
//	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
//	@Basic( optional = false )
//	@JoinColumn(name = "serviceId_fk", nullable = false )
//	public JdServices getServiceidFk() {
//		return this.serviceidFk;
//
//	}
//
//
//
//    /**
//     * Set the value related to the column: serviceidFk.
//	 * @param serviceidFk the serviceidFk value you wish to set
//	 */
//	public void setServiceidFk(final JdServices serviceidFk) {
//		this.serviceidFk = serviceidFk;
//	}
//
//
//   /**
//    * Deep copy.
//	* @return cloned object
//	* @throws CloneNotSupportedException on error
//    */
//    @Override
//    public JdClinicServiceCost clone() throws CloneNotSupportedException {
//
//        final JdClinicServiceCost copy = (JdClinicServiceCost)super.clone();
//
//		copy.setClinicidFk(this.getClinicidFk());
//		copy.setCost(this.getCost());
//		copy.setCreationdate(this.getCreationdate());
//		copy.setModifiedby(this.getModifiedby());
//		copy.setModifieddate(this.getModifieddate());
//		copy.setServiceidFk(this.getServiceidFk());
//		return copy;
//	}
//
//
//
//	/** Provides toString implementation.
//	 * @see Object#toString()
//	 * @return String representation of this class.
//	 */
//	@Override
//	public String toString() {
//		StringBuffer sb = new StringBuffer();
//
//		sb.append("cost: " + this.getCost() + ", ");
//		sb.append("creationdate: " + this.getCreationdate() + ", ");
//		sb.append("modifiedby: " + this.getModifiedby() + ", ");
//		sb.append("modifieddate: " + this.getModifieddate() + ", ");
//		return sb.toString();
//	}
//
//
//	/** Equals implementation.
//	 * @see Object#equals(Object)
//	 * @param aThat Object to compare with
//	 * @return true/false
//	 */
//	@Override
//	public boolean equals(final Object aThat) {
//		Object proxyThat = aThat;
//
//		if ( this == aThat ) {
//			 return true;
//		}
//
//
//		if (aThat instanceof HibernateProxy) {
// 			// narrow down the proxy to the class we are dealing with.
// 			try {
//				proxyThat = ((HibernateProxy) aThat).getHibernateLazyInitializer().getImplementation();
//			} catch (org.hibernate.ObjectNotFoundException e) {
//				return false;
//		   	}
//		}
//		if (aThat == null)  {
//			 return false;
//		}
//
//		final JdClinicServiceCost that;
//		try {
//			that = (JdClinicServiceCost) proxyThat;
//			if ( !(that.getClassType().equals(this.getClassType()))){
//				return false;
//			}
//		} catch (org.hibernate.ObjectNotFoundException e) {
//				return false;
//		} catch (ClassCastException e) {
//				return false;
//		}
//
//
//		boolean result = true;
//		result = result && (((getClinicidFk() == null) && (that.getClinicidFk() == null)) || (getClinicidFk() != null && getClinicidFk().getId().equals(that.getClinicidFk().getId())));
//		result = result && (((getCost() == null) && (that.getCost() == null)) || (getCost() != null && getCost().equals(that.getCost())));
//		result = result && (((getCreationdate() == null) && (that.getCreationdate() == null)) || (getCreationdate() != null && getCreationdate().equals(that.getCreationdate())));
//		result = result && (((getModifiedby() == null) && (that.getModifiedby() == null)) || (getModifiedby() != null && getModifiedby().equals(that.getModifiedby())));
//		result = result && (((getModifieddate() == null) && (that.getModifieddate() == null)) || (getModifieddate() != null && getModifieddate().equals(that.getModifieddate())));
//		result = result && (((getServiceidFk() == null) && (that.getServiceidFk() == null)) || (getServiceidFk() != null && getServiceidFk().getId().equals(that.getServiceidFk().getId())));
//		return result;
//	}
//
//
//}
