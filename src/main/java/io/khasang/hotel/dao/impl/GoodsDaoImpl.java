package io.khasang.hotel.dao.impl;

import io.khasang.hotel.dao.GoodsDao;
import io.khasang.hotel.entity.goods.Goods;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class GoodsDaoImpl extends BasicDaoImpl<Goods> implements GoodsDao {
    public GoodsDaoImpl(Class<Goods> entityClass) {
        super(entityClass);
    }

    public Goods deleteById(long id) {
        Session session = sessionFactory.getCurrentSession();
        Goods goods = session.get(Goods.class, id);
        session.delete(goods);
        return goods;
    }

    @Override
    public Goods add(Goods goods) {
        sessionFactory.getCurrentSession().persist(goods);
        return goods;
    }
}
