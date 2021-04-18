import React from 'react';
import {
    View,
    Text,
    ImageBackground,
    Image,
    Animated
} from 'react-native';

import SlidingUpPanel from 'rn-sliding-up-panel';
import MapView , {PROVIDER_GOOGLE, Marker} from "react-native-maps";
import { HeaderBar, TextIconsButton } from '../components';
import { COLORS, SIZES, FONTS, icons } from "../constants"

import {} from "../styles";

const Place = ({navigation, route}) => {

    const [ selectedPlace, setSelectedPlace ] = React.useState(null)

    let _panel = React.useRef(null);

    React.useEffect(() =>{
        let {selectedPlace} = route.params;
        setSelectedPlace(selectedPlace)
    }, [])

    function renderPlace(){
        return(
            <ImageBackground
               source={selectedPlace?.image} 
               style={{
                   width:"100%",
                   height:"100%"
               }}>
                   <HeaderBar 
                    title=""
                    leftOnPressed={() => navigation.goBack()}
                    right={false}
                    containerStyle={{
                        marginTop: SIZES.padding * 2
                    }}
                   />

                   <View
                    style={{
                        flex: 1,
                        paddingHorizontal: SIZES.padding,
                        justifyContent: 'flex-end',
                        marginBottom: 100
                    }}>
                       <View
                        style={{
                            flexDirection: 'row',
                            alignItems: 'center',
                            justifyContent: 'space-between'
                        }}>
                            <Text
                                style={{color: COLORS.white,
                                ...FONTS.largeTitle}}>
                                    {selectedPlace?.name}
                            </Text>
                        <View
                        style={{
                            flexDirection:'row',
                            alignItems:'center'
                        }}>
                            <Text style={{
                                marginRight:5, color: 
                                COLORS.white, ...FONTS.h3
                            }}>{selectedPlace?.rate}</Text>
                            <Image 
                                source={icons.star}
                                style={{
                                    width:20,
                                    height:20
                                }}
                            />
                        </View>
                       </View>
                       <Text style={{
                           marginTop: SIZES.base, color: COLORS.white
                       }}>{selectedPlace?.description}</Text>
                       <TextIconsButton
                            label="Book a flight"
                            icon={icons.aeroplane}
                            customContainerStyle={{
                                marginTop: SIZES.padding
                            }}
                            onPress={()=> console.log('Book a flight')}
                       />
                   </View>
            </ImageBackground>
        )
    }

    function renderMap(){
        return(
            <SlidingUpPanel
                ref={c=>(_panel = c)}
                draggableRange={{ top: SIZES.height + 120, bottom: 120}}
                showBackdrop={false}
                snappingPoints={[SIZES.height + 120]}
                height={SIZES.height + 120}
                friction={0.7}
                >
                <View
                style={{flex:1,
                        backgroundColor: "transparent"}}>
                <View style={{
                    height:120,
                    backgroundColor: "transparent",
                    alignItems: 'center',
                    justifyContent:'center'
                }}>
                    <Image 
                        source={icons.up_arrow}
                        style={{
                            width:20,
                            height:20,
                            tintColor: COLORS.white
                        }}
                    />
                    <Text style={{ color: COLORS.white, ...FONTS.h3 }}> Swipe for details </Text>
                    </View>
                    <View
                    style=
                    {{flex:1,
                        backgroundColor: COLORS.white,
                        alignItems: 'center',
                        justifyContent:'center'
                        }}
                        >
                            <MapView
                                style={{
                                    width:"100%",
                                    height: "100%"
                                }}
                                provider={PROVIDER_GOOGLE}
                                initialRegion={selectedPlace?.mapInitalRegion}
                                >

                            </MapView>
                </View>
            </View>
            </SlidingUpPanel>
        )
    }

    return (
        <View style={{ flex: 1, alignItems: 'center', justifyContent: 'center' }}>
            {renderPlace()}
            {renderMap()}
        </View>
    )
}

export default Place;