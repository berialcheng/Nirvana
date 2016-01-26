package org.nirvana;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PHONE")
public class Phone implements Serializable
{
    @Id
    @Column(name = "NUMBER")
    private String number;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_ID")
    private Person person;

    public String getNumber()
    {
        return number;
    }

    public Phone(String number, Person person)
    {
        super();
        this.number = number;
        this.person = person;
    }

    public Phone()
    {
        // TODO Auto-generated constructor stub
    }

    public Person getPerson()
    {
        return person;
    }

    public void setPerson(Person person)
    {
        this.person = person;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }
}
