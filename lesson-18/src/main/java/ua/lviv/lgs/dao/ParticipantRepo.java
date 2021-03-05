package ua.lviv.lgs.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import ua.lviv.lgs.domain.Level;
import ua.lviv.lgs.domain.Participant;

@Repository
public class ParticipantRepo {

	private List<Participant> participants = new ArrayList<Participant>();

	@PostConstruct
	public void init() {
		Participant p1 = new Participant();
		p1.setId(1);
		p1.setName("Max");
		p1.setEmail("max@mail.com");
		p1.setLevel(Level.L1);
		p1.setPrimarySkill("Defence");

		Participant p2 = new Participant();
		p2.setId(2);
		p2.setName("Andrew");
		p2.setEmail("andrew@mail.com");
		p2.setLevel(Level.L2);
		p2.setPrimarySkill("Attack");

		Participant p3 = new Participant();
		p3.setId(3);
		p3.setName("Simple");
		p3.setEmail("simple@mail.com");
		p3.setLevel(Level.L5);
		p3.setPrimarySkill("AIM");

		participants.add(p1);
		participants.add(p2);
		participants.add(p3);
	}

	public List<Participant> findAll() {
		return participants;
	}

	public Participant findOne(Integer id) {
		return participants.stream().filter(participant -> participant.getId() == id).findFirst().orElse(null);
	}

	public void save(Participant participant) {
		Participant forUpdate = null;

		if (participant.getId() != null) {
			forUpdate = findOne(participant.getId());
			int pIndex = participants.indexOf(forUpdate);

			forUpdate.setName(participant.getName());
			forUpdate.setEmail(participant.getEmail());
			forUpdate.setLevel(participant.getLevel());
			forUpdate.setPrimarySkill(participant.getPrimarySkill());

			participants.set(pIndex, forUpdate);

		} else {
			participant.setId(participants.get(participants.size() - 1).getId() + 1);
			participants.add(participant);
		}
	}

	public void delete(Integer id) {
		Iterator<Participant> iterator = participants.iterator();

		while (iterator.hasNext()) {
			if (iterator.next().getId() == id) {
				iterator.remove();
			}
		}
	}

}
