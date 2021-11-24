package dao;

import java.util.List;

public interface IDAO<T, K> {

	public T findById(K id);
	public List<T> findAll();
	public void insert(T objet);
	public void update(T objet);
	public void delete(K id);

}
