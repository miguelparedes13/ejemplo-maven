/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infoloxa.catequesis.logica.dao;

import com.infoloxa.catequesis.model.Sacramentos;
import javax.ejb.Local;

/**
 *
 * @author anthoserv
 */
@Local
public interface SacramentoDao extends IGenericDao<Sacramentos, Long>  {
    
}
