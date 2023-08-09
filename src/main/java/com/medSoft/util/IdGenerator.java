package com.medSoft.util;

import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IdGenerator implements IdentifierGenerator {

	private static final long serialVersionUID = 1L;
	private static final String YYYY_MM_DD_HH_MM_SS = "yyyyMMddHHmmssns";

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(YYYY_MM_DD_HH_MM_SS);
		String id="";
		try {
			id = dateTime.format(dateTimeFormatter);
		} catch (DateTimeException e) {
			log.error("unable to fetch new Id having error" );
		}
		return Integer.valueOf(id);
	}
}
