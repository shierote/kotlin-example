package com.example.kotlinspringbootdomademo.infrastructure.domarepository

import com.example.kotlinspringbootdomademo.domain.model.Customer
import com.example.kotlinspringbootdomademo.domain.repository.CustomerRepository
import com.example.kotlinspringbootdomademo.infrastructure.doma.dao.CustomerDomaDao
import com.example.kotlinspringbootdomademo.infrastructure.doma.entity.CustomerDomaEntity
import org.springframework.stereotype.Repository

@Repository
class CustomerRepositoryDomaImpl(
        private val customerDomaDao: CustomerDomaDao
): CustomerRepository {
    override fun findAll(): List<Customer> {
        return customerDomaDao.selectAll().map { _mapToModel(it) }
    }

    override fun findById(id: Int): Customer? {
        return customerDomaDao.selectById(id)?.let { _mapToModel(it) }
    }

    override fun create(customer: Customer): Int {
        val domaEntity = _mapToDomaEntity(customer)
        customerDomaDao.insert(domaEntity)
        return domaEntity.id
    }

    override fun update(customer: Customer) {
        val domaEntity = _mapToDomaEntity(customer)
        customerDomaDao.update(domaEntity)
    }

    override fun delete(customer: Customer) {
        val domaEntity = _mapToDomaEntity(customer)
        customerDomaDao.delete(domaEntity)
    }

    // ここでDomaのEntity（Java）をドメインのModel（Kotlin）に詰め替える
    private fun _mapToModel(domaEntity: CustomerDomaEntity): Customer {
        return Customer(
                id = domaEntity.id,
                name = domaEntity.name,
                email = domaEntity.email,
                phone_number = domaEntity.phone_number,
                github_name = domaEntity.github_name,
                twitter_name = domaEntity.twitter_name,
                main_org = domaEntity.main_org,
                sub_org = domaEntity.sub_org
        )
    }

    // ここでドメインのModel（Kotlin）をDomaのEntity（Java）をに詰め替える
    private fun _mapToDomaEntity(customer: Customer): CustomerDomaEntity {
        return CustomerDomaEntity().also {
            it.id = customer.id
            it.name = customer.name
            it.email = customer.email
            it.phone_number = customer.phone_number
            it.github_name = customer.github_name
            it.twitter_name = customer.twitter_name
            it.main_org = customer.main_org
            it.sub_org = customer.sub_org
        }
    }
}
