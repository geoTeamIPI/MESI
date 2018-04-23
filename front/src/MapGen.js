import React, { Component } from 'react'
import L from 'leaflet';
import { GeoSearchControl, OpenStreetMapProvider } from 'leaflet-geosearch';


export default class MapGen extends Component {

    render() {
        const provider = new OpenStreetMapProvider();

        // const searchControl = new GeoSearchControl({
        //     provider: provider,
        // });

        const map = new L.Map('mapGen', {
            center: [51.505, -0.09],
            zoom: 13
        });


        new GeoSearchControl({
            provider: provider,                               // required
            showMarker: true,                                   // optional: true|false  - default true
            showPopup: false,                                   // optional: true|false  - default false
            marker: {                                           // optional: L.Marker    - default L.Icon.Default
                icon: new L.Icon.Default(),
                draggable: false,
            },
            popupFormat: ({ query, result }) => result.label,   // optional: function    - default returns result label
            maxMarkers: 1,                                      // optional: number      - default 1
            retainZoomLevel: false,                             // optional: true|false  - default false
            animateZoom: true,                                  // optional: true|false  - default true
            autoClose: false,                                   // optional: true|false  - default false
            searchLabel: 'Enter address',                       // optional: string      - default 'Enter address'
            keepResult: false                                   // optional: true|false  - default false
        }).addTo(map);



        return (
            <div className="maapamapma">
                <div id="map">

                </div>
            </div>

        )
    }
}