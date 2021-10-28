package be.abis.exercise.service;

import be.abis.exercise.model.ConversionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.format.DateTimeFormatter;

@Service
public class CurrencyServiceImpl implements CurrencyService {

	@Autowired
	private RestTemplate rt;

	private String baseUri = "https://api.exchangerate.host";

	@Override
	public double getExchangeRate(String fromCur, String toCur) {

		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(baseUri + "/convert")
				                            .queryParam("from", fromCur).queryParam("to", toCur);
		ResponseEntity<ConversionResult> cr = rt.exchange(uriBuilder.toUriString(), HttpMethod.GET, null, ConversionResult.class);
		ConversionResult r = cr.getBody();
		System.out.println("Date: " + r.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		double d = r.getResult();
		return d;
	}

}
