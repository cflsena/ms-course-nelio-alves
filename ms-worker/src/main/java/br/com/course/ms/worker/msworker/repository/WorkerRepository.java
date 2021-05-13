package br.com.course.ms.worker.msworker.repository;

import br.com.course.ms.worker.msworker.domain.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
