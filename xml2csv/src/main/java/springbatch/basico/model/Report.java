package springbatch.basico.model;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import springbatch.basico.adapter.JaxbBigDecimalAdapter;
import springbatch.basico.adapter.JaxbDateAdapter;

/**
 * DDL Derby:
 * CREATE TABLE report (refId INT PRIMARY KEY, name VARCHAR(50), age INT, dob DATE, income DECIMAL(12, 2); 
 */
@XmlRootElement(name = "record")
public class Report {
	
	private int refId;
	private String name;
	private int age;
	private Date dob;
	private BigDecimal income;

	@XmlAttribute(name = "refId")
	public int getRefId() {
		return refId;
	}

	public void setRefId(int refId) {
		this.refId = refId;
	}

	@XmlElement(name = "age")
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@XmlElement
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlJavaTypeAdapter(JaxbDateAdapter.class)
	@XmlElement
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@XmlJavaTypeAdapter(JaxbBigDecimalAdapter.class)
	@XmlElement
	public BigDecimal getIncome() {
		return income;
	}

	public void setIncome(BigDecimal income) {
		this.income = income;
	}

	// for csv file only
	public String getCsvDob() {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(getDob());

	}

}