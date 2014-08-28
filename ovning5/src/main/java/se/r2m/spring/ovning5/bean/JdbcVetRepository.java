/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package se.r2m.spring.ovning5.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import se.r2m.spring.ovning5.model.Vet;

@Repository
public class JdbcVetRepository {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcVetRepository(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public Collection<Vet> findAll() throws DataAccessException {
		List<Vet> vets = new ArrayList<Vet>();
		vets.addAll(
				this.jdbcTemplate.query(
						"SELECT id, first_name, last_name FROM vets ORDER BY last_name,first_name",
						ParameterizedBeanPropertyRowMapper.newInstance(Vet.class)));
		return vets;
	}
}
