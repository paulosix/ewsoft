package br.com.ewsoft.seguranca.model.types;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.ParameterizedType;
import org.hibernate.usertype.UserType;

@SuppressWarnings("rawtypes")
public class EnumUserType implements UserType, ParameterizedType {


	private Class enumClass;

	public EnumUserType() {
		super();
	}

	@Override
	public void setParameterValues(Properties parameters) {
		String enumClassName = parameters.getProperty("enumClassName");
		try {
			enumClass = (Class) Class.forName(enumClassName);
		} catch (ClassNotFoundException e) {
			throw new HibernateException("Enum class not found ", e);
		}

	}

	@Override
	public int[] sqlTypes() {
		return new int[] { Types.OTHER };
	}

	@Override
	public Class returnedClass() {
		return enumClass;
	}

	@Override
	public boolean equals(Object x, Object y) throws HibernateException {
		return x == y;
	}

	@Override
	public int hashCode(Object x) throws HibernateException {
		return x.hashCode();
	}

	@Override
	@SuppressWarnings("unchecked")
	public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session,Object owner)
			throws HibernateException, SQLException {
		String pgObject = rs.getString(names[0]);
		try {
			return Enum.valueOf(enumClass, pgObject);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session)
			throws HibernateException, SQLException {
		if (value == null) {
			st.setNull(index, Types.OTHER);
		} else {
			st.setObject(index,((Enum) value), Types.OTHER);
		}
	}


	/*@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index,
			SessionImplementor session) throws HibernateException, SQLException {
		// TODO Auto-generated method stub

	}*/



	@Override
	public Object deepCopy(Object value) throws HibernateException {
		return value;
	}

	@Override
	public boolean isMutable() {
		return false;
	}

	@Override
	public Serializable disassemble(Object value) throws HibernateException {
		return (Enum) value;
	}

	@Override
	public Object assemble(Serializable cached, Object owner)
			throws HibernateException {
		return cached;
	}

	@Override
	public Object replace(Object original, Object target, Object owner)
			throws HibernateException {
		return original;
	}

	@SuppressWarnings("unchecked")
	public Object fromXMLString(String xmlValue) {
		return Enum.valueOf(enumClass, xmlValue);
	}

	public String objectToSQLString(Object value) {
		return '\'' + ((Enum) value).name() + '\'';
	}

	public String toXMLString(Object value) {
		return ((Enum) value).name();
	}


}

