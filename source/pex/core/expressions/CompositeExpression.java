package pex.core.expressions;

import pex.core.expressions.Expression

import java.io.Serializable;

/**
 * Classe usada para representar uma expressao no programa
 *
 * @author Manuel e Goncalo
 */
public abstract class CompositeExpression implements Expression {
     private String _operatorName;

     /**
     * Retorna o nome da expressao
     *
     * @return String Retorna uma string que representa o nome da expressao
     */
     public String getOperatorName() {
          return _operatorName;
     }

     public boid setOperatorName(String name) {
          _operatorName = name;
     }
}