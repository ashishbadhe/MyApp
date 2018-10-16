package com.app.generator;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class IdGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SessionImplementor arg0, Object arg1)
			throws HibernateException {
		String prefix = "VEN-";
		int num = new Random().nextInt(1000);
		return prefix+num;
	}

}
