package com.store.resource;

import com.store.service.CommodityService;
import com.store.model.Commodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/api")
public class CommodityResource {

	private CommodityService stokeService;

	@Autowired
	public CommodityResource(CommodityService stokeService) {
		this.stokeService = stokeService;
	}

	@RequestMapping(value = "/commodities", method = RequestMethod.GET)
	public List<Commodity> listAllCommodities() {
		return stokeService.getAll();
	}

	@RequestMapping(value = "/get-commodity/{id}", method = RequestMethod.GET)
	public ResponseEntity<Commodity> getCommodity(@PathVariable("id") int id) {

			Commodity commodity = stokeService.getCommodity(id);
			if (commodity != null) {
				return ResponseEntity.status(HttpStatus.OK).body(commodity);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}

	}

	@RequestMapping(value = "/delete-commodity/{id}", method = RequestMethod.DELETE)
	public String deleteCommodity(@PathVariable("id") int id) {

		try {
			stokeService.deleteCommodity(id);
			return  String.valueOf(ResponseEntity.status(HttpStatus.OK));
		} catch (EntityNotFoundException e) {
			return String.valueOf(ResponseEntity.status(HttpStatus.BAD_REQUEST));
		}

	}

	@RequestMapping(value = "/add-commodity", method = RequestMethod.POST)
	public ResponseEntity<Void> addCommodityToList( @RequestBody Commodity commodity) {

		try {
			stokeService.addCommodity(commodity);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (EntityExistsException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@RequestMapping(value = "/update-commodity/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateCommodity(@RequestBody Commodity commodity) {

		try {
			stokeService.updateCommodity(commodity);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch(EntityNotFoundException e ) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

}
