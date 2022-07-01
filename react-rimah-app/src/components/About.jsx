import React from 'react';
import { Box, Text, VStack, Container, Flex } from '@chakra-ui/react';
const About = () => {
	return ( <Flex
        w={'full'}
        h={'100vh'}
        backgroundImage={"https://images.unsplash.com/photo-1569466594095-b8cd77b835fd?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8OTN8fHZlZ2FufGVufDB8MHwwfHw%3D&auto=format&fit=crop&w=500&q=60"}
        backgroundSize={'cover'}
        backgroundPosition={'center center'}>
			<VStack  align="center">
			<Box mt={150} >
				<Text noOfLines={[1, 2, 3]} fontSize='4xl' as='mark'>The vegan diet</Text>
				<Container mt={30} mb={90} fontSize='2xl' fontWeight='bold' >A vegan diet contains only plants (such as vegetables, grains, nuts and fruits) and foods made from plants.
				Vegans do not eat foods that come from animals, including dairy products and eggs.</Container>
		</Box></VStack>	
		</Flex>	
	);
};
export default About;