//package com.techstomach.ehs.core;
//
//import java.io.Serializable;
//import java.util.Collections;
//import java.util.Date;
//import java.util.HashSet;
//import java.util.Map;
//import java.util.Set;
//import java.util.WeakHashMap;
//import javax.persistence.Basic;
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//import javax.persistence.Transient;
//import org.hibernate.proxy.HibernateProxy;
//
//
///**
// * Object mapping for hibernate-handled table: jd_services.
// * @author autogenerated
// */
//
//@Entity
//@Table(name = "jd_services", catalog = "jdehs_dev")
//public class JdServices implements Cloneable, Serializable{
//
//	/** Serial Version UID. */
//	private static final long serialVersionUID = -559033252L;
//
//	/** Use a WeakHashMap so entries will be garbage collected once all entities
//		referring to a saved hash are garbage collected themselves. */
//	private static final Map<Serializable, Long> SAVED_HASHES =
//		Collections.synchronizedMap(new WeakHashMap<Serializable, Long>());
//
//	/** hashCode temporary storage. */
//	private volatile Long hashCode;
//
//
//	/** Field mapping. */
//	private Double cost;
//	/** Field mapping. */
//	private Date creationdate;
//	/** Field mapping. */
//	private Long id = 0L; // init for hibernate bug workaround
//	/** Field mapping. */
//	private Set<JdClinicServiceCost> jdClinicServiceCosts = new HashSet<JdClinicServiceCost>();
//
//	/** Field mapping. */
//	private Set<JdClinicServiceMap> jdClinicServiceMaps = new HashSet<JdClinicServiceMap>();
//
//	/** Field mapping. */
//	private Set<JdCorporatePackageClinicServiceMap> jdCorporatePackageClinicServiceMaps = new HashSet<JdCorporatePackageClinicServiceMap>();
//
//	/** Field mapping. */
//	private String modifiedby;
//	/** Field mapping. */
//	private Date modifieddate;
//	/** Field mapping. */
//	private String servicecode;
//	/** Field mapping. */
//	private String servicedescription;
//	/** Field mapping. */
//	private String servicename;
//	/**
//	 * Default constructor, mainly for hibernate use.
//	 */
//	public JdServices() {
//		// Default constructor
//	}
//
//	/** Constructor taking a given ID.
//	 * @param id to set
//	 */
//	public JdServices(Long id) {
//		this.id = id;
//	}
//
//	/** Constructor taking a given ID.
//	 * @param cost Double object;
//	 * @param id Long object;
//	 * @param modifiedby String object;
//	 * @param servicecode String object;
//	 * @param servicedescription String object;
//	 * @param servicename String object;
//	 */
//	public JdServices(Double cost, Long id, String modifiedby,
//			String servicecode, String servicedescription, String servicename) {
//
//		this.cost = cost;
//		this.id = id;
//		this.modifiedby = modifiedby;
//		this.servicecode = servicecode;
//		this.servicedescription = servicedescription;
//		this.servicename = servicename;
//	}
//
//
//
//
//
//	/** Return the type of this class. Useful for when dealing with proxies.
//	* @return Defining class.
//	*/
//	@Transient
//	public Class<?> getClassType() {
//		return JdServices.class;
//	}
//
//
//    /**
//     * Return the value associated with the column: cost.
//	 * @return A Double object (this.cost)
//	 */
//	@Basic( optional = false )
//	@Column( nullable = false  )
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
//     * Return the value associated with the column: id.
//	 * @return A Long object (this.id)
//	 */
//    @Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Basic( optional = false )
//	@Column( name = "serviceid"  )
//	public Long getId() {
//		return this.id;
//
//	}
//
//
//
//    /**
//     * Set the value related to the column: id.
//	 * @param id the id value you wish to set
//	 */
//	public void setId(final Long id) {
//		// If we've just been persisted and hashCode has been
//		// returned then make sure other entities with this
//		// ID return the already returned hash code
//		if ( (this.id == null || this.id == 0L) &&
//				(id != null) &&
//				(this.hashCode != null) ) {
//		SAVED_HASHES.put( id, this.hashCode );
//		}
//		this.id = id;
//	}
//
//    /**
//     * Return the value associated with the column: jdClinicServiceCost.
//	 * @return A Set&lt;JdClinicServiceCost&gt; object (this.jdClinicServiceCost)
//	 */
// 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "serviceidFk"  )
// 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
//	@Basic( optional = false )
//	@Column( nullable = false  )
//	public Set<JdClinicServiceCost> getJdClinicServiceCosts() {
//		return this.jdClinicServiceCosts;
//
//	}
//
//	/**
//	 * Adds a bi-directional link of type JdClinicServiceCost to the jdClinicServiceCosts set.
//	 * @param jdClinicServiceCost item to add
//	 */
//	public void addJdClinicServiceCost(JdClinicServiceCost jdClinicServiceCost) {
//		jdClinicServiceCost.setServiceidFk(this);
//		this.jdClinicServiceCosts.add(jdClinicServiceCost);
//	}
//
//
//    /**
//     * Set the value related to the column: jdClinicServiceCost.
//	 * @param jdClinicServiceCost the jdClinicServiceCost value you wish to set
//	 */
//	public void setJdClinicServiceCosts(final Set<JdClinicServiceCost> jdClinicServiceCost) {
//		this.jdClinicServiceCosts = jdClinicServiceCost;
//	}
//
//    /**
//     * Return the value associated with the column: jdClinicServiceMap.
//	 * @return A Set&lt;JdClinicServiceMap&gt; object (this.jdClinicServiceMap)
//	 */
// 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "serviceidFk"  )
// 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
//	@Basic( optional = false )
//	@Column( nullable = false  )
//	public Set<JdClinicServiceMap> getJdClinicServiceMaps() {
//		return this.jdClinicServiceMaps;
//
//	}
//
//	/**
//	 * Adds a bi-directional link of type JdClinicServiceMap to the jdClinicServiceMaps set.
//	 * @param jdClinicServiceMap item to add
//	 */
//	public void addJdClinicServiceMap(JdClinicServiceMap jdClinicServiceMap) {
//		jdClinicServiceMap.setServiceidFk(this);
//		this.jdClinicServiceMaps.add(jdClinicServiceMap);
//	}
//
//
//    /**
//     * Set the value related to the column: jdClinicServiceMap.
//	 * @param jdClinicServiceMap the jdClinicServiceMap value you wish to set
//	 */
//	public void setJdClinicServiceMaps(final Set<JdClinicServiceMap> jdClinicServiceMap) {
//		this.jdClinicServiceMaps = jdClinicServiceMap;
//	}
//
//    /**
//     * Return the value associated with the column: jdCorporatePackageClinicServiceMap.
//	 * @return A Set&lt;JdCorporatePackageClinicServiceMap&gt; object (this.jdCorporatePackageClinicServiceMap)
//	 */
// 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "serviceidFk"  )
// 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
//	@Basic( optional = false )
//	@Column( nullable = false  )
//	public Set<JdCorporatePackageClinicServiceMap> getJdCorporatePackageClinicServiceMaps() {
//		return this.jdCorporatePackageClinicServiceMaps;
//
//	}
//
//	/**
//	 * Adds a bi-directional link of type JdCorporatePackageClinicServiceMap to the jdCorporatePackageClinicServiceMaps set.
//	 * @param jdCorporatePackageClinicServiceMap item to add
//	 */
//	public void addJdCorporatePackageClinicServiceMap(JdCorporatePackageClinicServiceMap jdCorporatePackageClinicServiceMap) {
//		jdCorporatePackageClinicServiceMap.setServiceidFk(this);
//		this.jdCorporatePackageClinicServiceMaps.add(jdCorporatePackageClinicServiceMap);
//	}
//
//
//    /**
//     * Set the value related to the column: jdCorporatePackageClinicServiceMap.
//	 * @param jdCorporatePackageClinicServiceMap the jdCorporatePackageClinicServiceMap value you wish to set
//	 */
//	public void setJdCorporatePackageClinicServiceMaps(final Set<JdCorporatePackageClinicServiceMap> jdCorporatePackageClinicServiceMap) {
//		this.jdCorporatePackageClinicServiceMaps = jdCorporatePackageClinicServiceMap;
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
//     * Return the value associated with the column: servicecode.
//	 * @return A String object (this.servicecode)
//	 */
//	@Basic( optional = false )
//	@Column( nullable = false, length = 255  )
//	public String getServicecode() {
//		return this.servicecode;
//
//	}
//
//
//
//    /**
//     * Set the value related to the column: servicecode.
//	 * @param servicecode the servicecode value you wish to set
//	 */
//	public void setServicecode(final String servicecode) {
//		this.servicecode = servicecode;
//	}
//
//    /**
//     * Return the value associated with the column: servicedescription.
//	 * @return A String object (this.servicedescription)
//	 */
//	@Basic( optional = false )
//	@Column( nullable = false, length = 1000  )
//	public String getServicedescription() {
//		return this.servicedescription;
//
//	}
//
//
//
//    /**
//     * Set the value related to the column: servicedescription.
//	 * @param servicedescription the servicedescription value you wish to set
//	 */
//	public void setServicedescription(final String servicedescription) {
//		this.servicedescription = servicedescription;
//	}
//
//    /**
//     * Return the value associated with the column: servicename.
//	 * @return A String object (this.servicename)
//	 */
//	@Basic( optional = false )
//	@Column( nullable = false, length = 255  )
//	public String getServicename() {
//		return this.servicename;
//
//	}
//
//
//
//    /**
//     * Set the value related to the column: servicename.
//	 * @param servicename the servicename value you wish to set
//	 */
//	public void setServicename(final String servicename) {
//		this.servicename = servicename;
//	}
//
//
//   /**
//    * Deep copy.
//	* @return cloned object
//	* @throws CloneNotSupportedException on error
//    */
//    @Override
//    public JdServices clone() throws CloneNotSupportedException {
//
//        final JdServices copy = (JdServices)super.clone();
//
//		copy.setCost(this.getCost());
//		copy.setCreationdate(this.getCreationdate());
//		copy.setId(this.getId());
//		if (this.getJdClinicServiceCosts() != null) {
//			copy.getJdClinicServiceCosts().addAll(this.getJdClinicServiceCosts());
//		}
//		if (this.getJdClinicServiceMaps() != null) {
//			copy.getJdClinicServiceMaps().addAll(this.getJdClinicServiceMaps());
//		}
//		if (this.getJdCorporatePackageClinicServiceMaps() != null) {
//			copy.getJdCorporatePackageClinicServiceMaps().addAll(this.getJdCorporatePackageClinicServiceMaps());
//		}
//		copy.setModifiedby(this.getModifiedby());
//		copy.setModifieddate(this.getModifieddate());
//		copy.setServicecode(this.getServicecode());
//		copy.setServicedescription(this.getServicedescription());
//		copy.setServicename(this.getServicename());
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
//		sb.append("id: " + this.getId() + ", ");
//		sb.append("modifiedby: " + this.getModifiedby() + ", ");
//		sb.append("modifieddate: " + this.getModifieddate() + ", ");
//		sb.append("servicecode: " + this.getServicecode() + ", ");
//		sb.append("servicedescription: " + this.getServicedescription() + ", ");
//		sb.append("servicename: " + this.getServicename());
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
//		final JdServices that;
//		try {
//			that = (JdServices) proxyThat;
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
//		result = result && (((this.getId() == null) && ( that.getId() == null)) || (this.getId() != null  && this.getId().equals(that.getId())));
//		result = result && (((getCost() == null) && (that.getCost() == null)) || (getCost() != null && getCost().equals(that.getCost())));
//		result = result && (((getCreationdate() == null) && (that.getCreationdate() == null)) || (getCreationdate() != null && getCreationdate().equals(that.getCreationdate())));
//		result = result && (((getModifiedby() == null) && (that.getModifiedby() == null)) || (getModifiedby() != null && getModifiedby().equals(that.getModifiedby())));
//		result = result && (((getModifieddate() == null) && (that.getModifieddate() == null)) || (getModifieddate() != null && getModifieddate().equals(that.getModifieddate())));
//		result = result && (((getServicecode() == null) && (that.getServicecode() == null)) || (getServicecode() != null && getServicecode().equals(that.getServicecode())));
//		result = result && (((getServicedescription() == null) && (that.getServicedescription() == null)) || (getServicedescription() != null && getServicedescription().equals(that.getServicedescription())));
//		result = result && (((getServicename() == null) && (that.getServicename() == null)) || (getServicename() != null && getServicename().equals(that.getServicename())));
//		return result;
//	}
//
//	/** Calculate the hashcode.
//	 * @see Object#hashCode()
//	 * @return a calculated number
//	 */
//	@Override
//	public int hashCode() {
//		if ( this.hashCode == null ) {
//			synchronized ( this ) {
//				if ( this.hashCode == null ) {
//					Long newHashCode = null;
//
//					if ( getId() != null ) {
//					newHashCode = SAVED_HASHES.get( getId() );
//					}
//
//					if ( newHashCode == null ) {
//						if ( getId() != null && getId() != 0L) {
//							newHashCode = getId();
//						} else {
//							newHashCode = (long) super.hashCode();
//
//						}
//					}
//
//					this.hashCode = newHashCode;
//				}
//			}
//		}
//		return (int) (this.hashCode & 0xffffff);
//	}
//
//
//
//}
