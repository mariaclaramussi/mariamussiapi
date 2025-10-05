package br.edu.infnet.agendamento.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;

@FeignClient(name="brasilapi", url = "${clients.api.url}")
public interface BrasilApiFeignClients {

    @GetMapping("/api/consulta-feriados/{ano}")
    List<Feriado> obterFeriadosPorAno(@PathVariable("ano") String ano);

    class Feriado {

        private LocalDate date;
        private String name;
        private String type;

        public LocalDate getDate() {
            return date;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

}
