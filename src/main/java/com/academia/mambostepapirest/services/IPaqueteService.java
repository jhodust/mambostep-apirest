package com.academia.mambostepapirest.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.academia.mambostepapirest.dto.PaqueteDto;

@Service
public interface IPaqueteService {

	public List<PaqueteDto> listarPaquetes();
}
