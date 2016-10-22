package br.edu.fa7.main;

import br.edu.fa7.dao.GenericDao;
import br.edu.fa7.enums.Estado;
import br.edu.fa7.factory.HibernateFactory;
import br.edu.fa7.model.Aeroporto;
import br.edu.fa7.model.BaseModel;
import br.edu.fa7.model.Cidade;
import br.edu.fa7.model.EmpresaAerea;
import br.edu.fa7.model.Voo;
import org.hibernate.Session;

import java.util.Calendar;

public class CargaInicial {

    public static void main(String[] args) throws Exception {

        Session session = HibernateFactory.getHibernateSession();
        session.getTransaction().begin();

        GenericDao<BaseModel> gd = new GenericDao<>();

        //Criando Cidades
        Cidade fortaleza = new Cidade();
        fortaleza.setNome("Fortaleza");
        fortaleza.setEstado(Estado.CEARA);
        gd.salvar(fortaleza);

        Cidade salvador = new Cidade();
        salvador.setNome("Salvador");
        salvador.setEstado(Estado.BAHIA);
        gd.salvar(salvador);

        Cidade natal = new Cidade();
        natal.setNome("Natal");
        natal.setEstado(Estado.RIO_GRANDE_DO_NORTE);
        gd.salvar(natal);

        //Criando aeroporto
        Aeroporto aeroportoFortaleza = new Aeroporto();
        aeroportoFortaleza.setCidade(fortaleza);
        aeroportoFortaleza.setNome("Pinto Martins");
        gd.salvar(aeroportoFortaleza);

        Aeroporto aeroportoSalvador = new Aeroporto();
        aeroportoSalvador.setCidade(salvador);
        aeroportoSalvador.setNome("Deputado Luís Eduardo Magalhães");
        gd.salvar(aeroportoSalvador);

        Aeroporto aeroportoNatal = new Aeroporto();
        aeroportoNatal.setCidade(natal);
        aeroportoNatal.setNome("Augusto Severo");
        gd.salvar(aeroportoNatal);

        //Criando empresas aerea
        EmpresaAerea tam = new EmpresaAerea();
        tam.setNome("TAM");
        tam.setSigla("JJ");
        gd.salvar(tam);

        EmpresaAerea gol = new EmpresaAerea();
        gol.setNome("Gol");
        gol.setSigla("GO");
        gd.salvar(gol);

        EmpresaAerea azul = new EmpresaAerea();
        azul.setNome("Azul");
        azul.setSigla("AZ");
        gd.salvar(azul);

        //Criando voos
        Voo vooFortalezaNatal = new Voo();
        vooFortalezaNatal.setSigla("JJ");
        vooFortalezaNatal.setNumero("1234");
        vooFortalezaNatal.setAeroportoSaida(aeroportoFortaleza);
        vooFortalezaNatal.setAeroportoChegada(aeroportoNatal);

        Calendar timestampSaida = Calendar.getInstance();
        timestampSaida.set(Calendar.YEAR, 2016);
        timestampSaida.set(Calendar.MONTH, Calendar.OCTOBER);
        timestampSaida.set(Calendar.DAY_OF_MONTH, 25);
        timestampSaida.set(Calendar.HOUR, 10);
        timestampSaida.set(Calendar.MINUTE, 30);
        timestampSaida.set(Calendar.SECOND, 0);

        vooFortalezaNatal.setDataHoraPrevistoSaida(timestampSaida.getTime());

        Calendar timestampChegada = Calendar.getInstance();
        timestampChegada.set(Calendar.YEAR, 2016);
        timestampChegada.set(Calendar.MONTH, Calendar.OCTOBER);
        timestampChegada.set(Calendar.DAY_OF_MONTH, 25);
        timestampChegada.set(Calendar.HOUR, 11);
        timestampChegada.set(Calendar.MINUTE, 45);
        timestampChegada.set(Calendar.SECOND, 0);

        vooFortalezaNatal.setDataHoraPrevistoChegada(timestampChegada.getTime());
        vooFortalezaNatal.setEmpresaAerea(tam);
        vooFortalezaNatal.setQuantidadeAssentosDisponiveis(100);
        vooFortalezaNatal.setValor(500.0);
        gd.salvar(vooFortalezaNatal);

        Voo vooSalvadorFortaleza = new Voo();
        vooSalvadorFortaleza.setSigla("AZ");
        vooSalvadorFortaleza.setNumero("4433");
        vooSalvadorFortaleza.setAeroportoSaida(aeroportoSalvador);
        vooSalvadorFortaleza.setAeroportoChegada(aeroportoFortaleza);

        timestampSaida = Calendar.getInstance();
        timestampSaida.set(Calendar.YEAR, 2016);
        timestampSaida.set(Calendar.MONTH, Calendar.OCTOBER);
        timestampSaida.set(Calendar.DAY_OF_MONTH, 26);
        timestampSaida.set(Calendar.HOUR, 3);
        timestampSaida.set(Calendar.MINUTE, 15);
        timestampSaida.set(Calendar.SECOND, 0);

        vooSalvadorFortaleza.setDataHoraPrevistoSaida(timestampSaida.getTime());

        timestampChegada = Calendar.getInstance();
        timestampChegada.set(Calendar.YEAR, 2016);
        timestampChegada.set(Calendar.MONTH, Calendar.OCTOBER);
        timestampChegada.set(Calendar.DAY_OF_MONTH, 26);
        timestampChegada.set(Calendar.HOUR, 10);
        timestampChegada.set(Calendar.MINUTE, 25);
        timestampChegada.set(Calendar.SECOND, 0);

        vooSalvadorFortaleza.setDataHoraPrevistoChegada(timestampChegada.getTime());
        vooSalvadorFortaleza.setEmpresaAerea(azul);
        vooSalvadorFortaleza.setQuantidadeAssentosDisponiveis(80);
        vooSalvadorFortaleza.setValor(600.0);
        gd.salvar(vooSalvadorFortaleza);

//		session.get(Pessoa.class, new Integer(1));


        session.getTransaction().commit();
    }
}
