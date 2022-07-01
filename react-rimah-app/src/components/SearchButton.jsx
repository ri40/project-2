import React from 'react';
import { Box } from '@chakra-ui/react';
const SearchButton = ({ onClick, searchBtn }) => {
	return (
<Box
        as="button"
        p={4}
        color="white"
		onClick={onClick}
        fontWeight="bold"
        borderRadius="lg"
        bgGradient="linear(to-r, teal.500, green.500)"
        _hover={{ bgGradient: 'linear(to-r, red.500, yellow.500)', }}>
		{/* <Link to={searchBtn}></Link> */}
		{searchBtn}
      </Box>
	);
};

export default SearchButton;