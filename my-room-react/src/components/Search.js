import React from 'react';
import {
    Button,
    Input,
    InputGroup,
    InputRightElement,
  } from '@chakra-ui/react';
  export default function Search() {
    const [Search, setSearch] = React.useState(false)
    const handleClick = () => setSearch(!Search)
  
    return (
      <InputGroup size='md'>
        <Input
          pr='4.5rem'
          type={Search ? 'text' : 'Searh'}
          placeholder='Enter Cafa'
        />
        <InputRightElement width='4.5rem'>
          <Button h='1.75rem' size='sm' onClick={handleClick}>
            {Search ? 'search' : 'search'}
          </Button>
        </InputRightElement>
      </InputGroup>
    )
  }