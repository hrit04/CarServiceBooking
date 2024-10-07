//package com.hritam.CarServiceAgency.Dao.Impl;
//
//
//import com.hritam.CarServiceAgency.Dao.CarServiceAgencyDataDao;
//import com.hritam.CarServiceAgency.Entity.BookingData;
//import jakarta.transaction.Transactional;
//import org.springframework.data.domain.Example;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.repository.query.FluentQuery;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.function.Function;
//
//
//public class CarServiceAgencyDataDaoImpl implements CarServiceAgencyDataDao {
//
//
//    @Override
//    public BookingData getBookingDataById(Long id) {
//        return null;
//    }
//
//    @Override
//    public void flush() {
//
//    }
//
//    @Override
//    public <S extends BookingData> S saveAndFlush(S entity) {
//        return null;
//    }
//
//    @Override
//    public <S extends BookingData> List<S> saveAllAndFlush(Iterable<S> entities) {
//        return List.of();
//    }
//
//    @Override
//    public void deleteAllInBatch(Iterable<BookingData> entities) {
//
//    }
//
//    @Override
//    public void deleteAllByIdInBatch(Iterable<Long> longs) {
//
//    }
//
//    @Override
//    public void deleteAllInBatch() {
//
//    }
//
//    @Override
//    public BookingData getOne(Long aLong) {
//        return null;
//    }
//
//    @Override
//    public BookingData getById(Long aLong) {
//        return null;
//    }
//
//    @Override
//    public BookingData getReferenceById(Long aLong) {
//        return null;
//    }
//
//    @Override
//    public <S extends BookingData> Optional<S> findOne(Example<S> example) {
//        return Optional.empty();
//    }
//
//    @Override
//    public <S extends BookingData> List<S> findAll(Example<S> example) {
//        return List.of();
//    }
//
//    @Override
//    public <S extends BookingData> List<S> findAll(Example<S> example, Sort sort) {
//        return List.of();
//    }
//
//    @Override
//    public <S extends BookingData> Page<S> findAll(Example<S> example, Pageable pageable) {
//        return null;
//    }
//
//    @Override
//    public <S extends BookingData> long count(Example<S> example) {
//        return 0;
//    }
//
//    @Override
//    public <S extends BookingData> boolean exists(Example<S> example) {
//        return false;
//    }
//
//    @Override
//    public <S extends BookingData, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
//        return null;
//    }
//
//    @Override
//    public  <S extends BookingData> S save(S entity) {
//        return null;
//    }
//
//    @Override
//    public <S extends BookingData> List<S> saveAll(Iterable<S> entities) {
//        return List.of();
//    }
//
//    @Override
//    public Optional<BookingData> findById(Long aLong) {
//        return Optional.empty();
//    }
//
//    @Override
//    public boolean existsById(Long aLong) {
//        return false;
//    }
//
//    @Override
//    public List<BookingData> findAll() {
//        return List.of();
//    }
//
//    @Override
//    public List<BookingData> findAllById(Iterable<Long> longs) {
//        return List.of();
//    }
//
//    @Override
//    public long count() {
//        return 0;
//    }
//
//    @Override
//    public void deleteById(Long aLong) {
//
//    }
//
//    @Override
//    public void delete(BookingData entity) {
//
//    }
//
//    @Override
//    public void deleteAllById(Iterable<? extends Long> longs) {
//
//    }
//
//    @Override
//    public void deleteAll(Iterable<? extends BookingData> entities) {
//
//    }
//
//    @Override
//    public void deleteAll() {
//
//    }
//
//    @Override
//    public List<BookingData> findAll(Sort sort) {
//        return List.of();
//    }
//
//    @Override
//    public Page<BookingData> findAll(Pageable pageable) {
//        return null;
//    }
//}
