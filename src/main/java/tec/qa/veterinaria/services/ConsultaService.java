package tec.qa.veterinaria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tec.qa.veterinaria.interfaceServices.IConsultaService;
import tec.qa.veterinaria.interfaces.IConsulta;
import tec.qa.veterinaria.model.Consulta;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService implements IConsultaService {
    @Autowired
    private IConsulta data;

    @Override
    public List<Consulta> listar() {

        return (List<Consulta>)data.findAll();
    }

    @Override
    public Optional<Consulta> listarId(int id) {
        return data.findById(id);
    }

    @Override
    public boolean save(Consulta consulta) {

        try {
            if (consulta != null) {
                Consulta consulta1 = data.save(consulta);
                if (consulta1 != null) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public boolean delete(int id) {
        try {
            if (data.existsById(id)) {
                data.deleteById(id);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
