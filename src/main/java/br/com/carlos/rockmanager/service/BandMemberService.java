package br.com.carlos.rockmanager.service;

import br.com.carlos.rockmanager.model.BandMember;
import br.com.carlos.rockmanager.repository.BandMemberRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BandMemberService {

    private final BandMemberRepository bandMemberRepository;

    public BandMemberService(BandMemberRepository bandMemberRepository) {
        this.bandMemberRepository = bandMemberRepository;
    }

    public List<BandMember.BandMemberInfo> listBandMembers() {
        List<Object[]> results = bandMemberRepository.findBandMembers();
        return getBandMemberInfos(results);
    }

    public List<BandMember.BandMemberInfo> getBandMembersByBandId(int id) {
        List<Object[]> results = bandMemberRepository.findMembersByBandId(id);
        return getBandMemberInfos(results);
    }

    public BandMember.BandMemberInfo getBandMemberById(int idUsuario, int idBanda) {
        List<Object[]> results = bandMemberRepository.findBandMemberById(idBanda, idUsuario);
        List<BandMember.BandMemberInfo> membros = getBandMemberInfos(results);
        return membros.isEmpty() ? null : membros.get(0); // espero que Deus me perdoe
    }

    private List<BandMember.BandMemberInfo> getBandMemberInfos(List<Object[]> results) {
        List<BandMember.BandMemberInfo> membros = new ArrayList<>();
        for (Object[] row : results) {
            BandMember.BandMemberInfo info = new BandMember.BandMemberInfo();
            info.setId_usuario((Integer) row[0]);
            info.setNome_usuario((String) row[1]);
            info.setId_banda((Integer) row[2]);
            info.setNome_banda((String) row[3]);
            info.setFuncao((String) row[4]);
            membros.add(info);
        }
        return membros;
    }

}

