package airlinesystem.dao;

import airlinesystem.entity.CheckIn;
import airlinesystem.exception.ObjetoNaoEncontradoException;

public interface CheckInDAO
{	
	public CheckIn find(long id) throws ObjetoNaoEncontradoException;
	
	public long add(CheckIn checkin);
}