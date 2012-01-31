package com.zdsbs.depth;

import java.util.ArrayList;
import java.util.List;

public class DoubleForLoop {

	private final Worker worker = null;

	public void depth(List<Truck> trucks) {
		for (Truck truck : trucks) {
			List<Shipment> removedShipments = truck.removeShipments();
			for (Shipment shipment : removedShipments) {
				worker.shelve(shipment);
			}
		}
	}

	public void breadth(List<Truck> trucks) {
		List<Shipment> shipments = new ArrayList<Shipment>();
		for (Truck truck : trucks) {
			shipments.addAll(truck.removeShipments());
		}

		for (Shipment shipment : shipments) {
			worker.shelve(shipment);
		}
	}

	public void shelveShipmentsFromTrucks(List<Truck> trucks) {
		for (Truck truck : trucks) {
			while (truck.notEmpty()) {
				for (Worker worker : workers) {
					if (worker.notBusy()) {
						if (truck.notEmpty()) {
							worker.removeShipment(truck);
							worker.shelveShipment();
						}
					}
				}
			}
		}
	}

	public void depth_abstracted(List<Truck> trucks) {
		for (Truck truck : trucks) {
			List<Shipment> removedShipments = truck.removeShipments();
			shelveShipments(removedShipments);
		}
	}

	public void shelveShipments(List<Shipment> removedShipments) {
		for (Shipment shipment : removedShipments) {
			worker.shelve(shipment);
		}
	}

	public static final class Shipment {
	}

	public static final class Truck {
		public List<Shipment> removeShipments() {
			return null;
		}

		public boolean notEmpty() {
			return false;
		}
	}

	public static final class Worker {
		public void shelve(Shipment shipment) {
		}

		public void shelveShipment() {
		}

		public void removeShipment(Truck truck) {
		}
	}
}
