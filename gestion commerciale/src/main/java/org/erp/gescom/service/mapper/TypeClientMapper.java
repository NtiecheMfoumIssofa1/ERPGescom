package org.erp.gescom.service.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.erp.gescom.domain.Client;
import org.erp.gescom.domain.TypeClient;
import org.erp.gescom.service.dto.TypeClientDTO;
import org.springframework.stereotype.Service;

@Service
public class TypeClientMapper {
	
	public TypeClientDTO typeToTypeDTO(TypeClient typeClient){
		return new TypeClientDTO(typeClient);
	}
	
	public List<TypeClientDTO> typesToTypeDTOs(List<TypeClient> typeClients){
		return typeClients.stream()
					.filter(Objects::nonNull)
					.map(this::typeToTypeDTO)
					.collect(Collectors.toList());
	}
	
	public TypeClient typeDTOToType(TypeClientDTO typeClientDTO){
		if(typeClientDTO == null){
			return null;
		}else{
			TypeClient typeClient = new TypeClient();
			typeClient.setEtat(typeClientDTO.isEtat());
			typeClient.setIdType(typeClientDTO.getIdType());
			typeClient.setLibelleType(typeClientDTO.getLibelleType());
			List<Client> clients = this.clientFromString(typeClientDTO.getClients());
				if(clients != null){
					typeClient.setClients(clients);
				}
			return typeClient;	
		}
	}
	
	public List<TypeClient> typeDTOsToTypeClient(List<TypeClientDTO> typeClientDTOs){
		return typeClientDTOs.stream()
					.filter(Objects::nonNull)
					.map(this::typeDTOToType)
					.collect(Collectors.toList());
	}
	
	public List<Client> clientFromString(List<String> strings){
		return strings.stream().map(string ->{
			Client client = new Client();
			client.setNomComplet(string);
			return client;
		}).collect(Collectors.toList());
	}

}
